#AppEggs

# 🐔 AppEggs — Poultry Farm Management System

> A production-grade REST API for managing the full lifecycle of a layer-hen poultry farm — from flock management and daily egg production to inventory control, feed procurement, and sales order fulfillment.

[![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=flat-square&logo=springboot)](https://spring.io/projects/spring-boot)
[![MapStruct](https://img.shields.io/badge/MapStruct-1.5-blue?style=flat-square)](https://mapstruct.org/)
[![Swagger](https://img.shields.io/badge/Swagger-OpenAPI_3.0-85EA2D?style=flat-square&logo=swagger)](https://swagger.io/)
[![License](https://img.shields.io/badge/License-MIT-lightgrey?style=flat-square)](LICENSE)

---

## Table of Contents

- [Overview](#overview)
- [Architecture Highlights](#architecture-highlights)
- [Domain Structure](#domain-structure)
- [API Endpoints](#api-endpoints)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Design Decisions](#design-decisions)

---

## Overview

AppEggs is a comprehensive back-end system built for `com.hindustries`, modeling the real-world operations of a commercial layer-hen farm. The system covers **5 business domains** with **35 entities**, **35 REST controllers**, and **71 DTOs** — all organized with strict domain separation.

The goal is not just CRUD. Each domain integrates with others to reflect actual farm business flows:

- Grading eggs automatically updates warehouse stock
- Feed consumption automatically deducts from feed inventory
- Purchase receiving triggers stock increment
- Sales orders track payment outstanding per customer

---

## Architecture Highlights

### Generic Base Layer with Template Method Pattern

Rather than duplicating CRUD logic across 35 services, the project uses a clean generic base:

```
BaseController<Req, Res, ID>      → handles POST / PUT / GET / DELETE
BaseService<Req, Res, ID>         → interface contract
BaseServiceImpl<E, Req, Res, ID>  → template implementation with lifecycle hooks
```

`BaseServiceImpl` exposes three optional hooks that concrete services can override without touching the core flow:

```java
protected void beforeCreate(Req req, Entity entity) {}
protected void afterCreate(Req req, Entity entity) {}
protected void beforeUpdate(Req req, Entity entity) {}
```

This means a service that needs side effects (e.g. auto-updating stock after grading) overrides only the relevant hook — the rest is inherited.

### Custom `@ResourceLabel` Annotation

Instead of hardcoding entity names in every `ResourceNotFoundException`, a custom runtime annotation `@ResourceLabel` is placed on each entity class:

```java
@ResourceLabel(Constant.KELOMPOK_AYAM)
public class KelompokAyam { ... }
```

`BaseServiceImpl` reads this at construction time via reflection, so all "not found" messages are consistent and centrally controlled — without any string duplication across 35 service files.

### MapStruct for Zero-Boilerplate Mapping

All entity ↔ DTO conversions use MapStruct with Spring injection. Nested relation fields are mapped declaratively:

```java
@Mapper(componentModel = "spring")
public interface KelompokAyamMapper {
    @Mapping(source = "ras.namaRas", target = "namaRas")
    @Mapping(source = "kandang.namaKandang", target = "namaKandang")
    KelompokAyamResponse toResponse(KelompokAyam entity);
    void updateEntityFromRequest(KelompokAyamRequest req, @MappingTarget KelompokAyam entity);
}
```

### Unified API Response Wrapper

All endpoints return a consistent envelope:

```json
{
  "success": true,
  "message": "Successfully",
  "data": { ... }
}
```

Error responses follow the same shape with `success: false` and a descriptive message — no raw stack traces exposed to clients.

### Global Exception Handling with SLF4J Logging

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    // → HTTP 404, log.warn(...)

    @ExceptionHandler(Exception.class)
    // → HTTP 500, log.error(...)
}
```

---

## Domain Structure

The system is divided into 5 clearly separated domains. Each domain owns its full vertical slice: `entity → repository → service → mapper → dto → controller`.

```
farm        →  Flock lifecycle, egg production, feed consumption,
               vaccination schedules, disease cases, culling
master      →  Reference data: farm, barn (kandang), breed (ras),
               feed type, customer, supplier
inventory   →  Warehouses (gudang), egg stock, feed stock, medicine stock,
               inventory items, movement transactions
commerce    →  Purchase orders, sales orders, egg sales, payment,
               delivery, order details
system      →  Users, roles, employees, daily & monthly reports
```

### Entity Map per Domain

| Domain | Entities |
|---|---|
| **farm** | `KelompokAyam` `ProduksiTelur` `GradingTelur` `KonsumsiPakan` `KematianAyam` `PengakiranAyam` `JadwalVaksin` `CatatanVaksinasi` `KasusPenyakit` |
| **master** | `Peternakan` `Kandang` `RasAyam` `JenisPakan` `Pelanggan` `Pemasok` |
| **inventory** | `Gudang` `StokTelur` `StokPakan` `StokObat` `BarangInventaris` `TransaksiInventaris` |
| **commerce** | `PesananPenjualan` `PesananPenjualanDetail` `PenjualanTelur` `PenjualanTelurDetail` `Pembayaran` `Pengiriman` `PesananPembelian` `PembelianPakan` `PembelianPakanDetail` |
| **system** | `Pengguna` `Peran` `Karyawan` `LaporanHarian` `LaporanBulanan` |

---

## API Endpoints

All endpoints follow the pattern `/api/{resource}` with standard CRUD operations inherited from `BaseController`. Domain-specific business actions are added as sub-resource endpoints.

### Farm Domain

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/kelompok-ayam` | Register a new flock |
| `GET` | `/api/kelompok-ayam/{id}/ringkasan` | Get flock summary: live population + age in days |
| `POST` | `/api/produksi-telur` | Record daily egg production |
| `GET` | `/api/produksi-telur/summary` | Aggregated production report by date range |
| `GET` | `/api/produksi-telur/hdp` | Compute Hen Day Production (%) — key farm KPI |
| `POST` | `/api/grading-telur` | Grade eggs by quality → auto-updates warehouse stock |
| `POST` | `/api/konsumsi-pakan` | Record feed consumption → auto-deducts feed stock |
| `POST` | `/api/pengakiran-ayam` | Record culling → auto-updates flock status |
| `POST` | `/api/jadwal-vaksin` | Schedule vaccination |
| `POST` | `/api/catatan-vaksinasi` | Record vaccination execution |
| `POST` | `/api/kasus-penyakit` | Log disease case |
| `POST` | `/api/kematian-ayam` | Record mortality |

### Inventory Domain

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/stok-telur` | Current egg stock by grade and warehouse |
| `GET` | `/api/stok-pakan` | Current feed stock by type and warehouse |
| `GET` | `/api/stok-pakan/alert` | Feed stocks below minimum threshold |
| `GET` | `/api/barang-inventaris/{id}/stok` | Computed live stock balance for an item |
| `GET` | `/api/barang-inventaris/{id}/riwayat` | Movement history with running balance |
| `GET` | `/api/stok-obat` | Medicine stock |

### Commerce Domain

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/pesanan-penjualan` | Create sales order |
| `PATCH` | `/api/pesanan-penjualan/{id}/status` | Advance order status (state machine) |
| `POST` | `/api/penjualan-telur` | Fulfill an order → auto-deducts egg stock |
| `GET` | `/api/pembayaran/outstanding` | Outstanding receivables per customer |
| `POST` | `/api/pembelian-pakan` | Create feed purchase order |
| `PATCH` | `/api/pembelian-pakan/{id}/terima` | Receive goods → auto-increments feed stock |
| `POST` | `/api/pengiriman` | Record delivery |

### Master & System Domain

| Method | Endpoint | Description |
|---|---|---|
| `GET/POST/PUT/DELETE` | `/api/kandang` | Barn / cage management |
| `GET/POST/PUT/DELETE` | `/api/pelanggan` | Customer management |
| `GET/POST/PUT/DELETE` | `/api/pemasok` | Supplier management |
| `GET/POST/PUT/DELETE` | `/api/jenis-pakan` | Feed type reference data |
| `GET/POST/PUT/DELETE` | `/api/ras-ayam` | Breed reference data |
| `GET/POST/PUT/DELETE` | `/api/pengguna` | User accounts |
| `GET/POST/PUT/DELETE` | `/api/peran` | Role management |
| `GET/POST/PUT/DELETE` | `/api/karyawan` | Employee records |
| `GET` | `/api/laporan-harian` | Daily operational report |
| `GET` | `/api/laporan-bulanan` | Monthly summary report |

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.x |
| ORM | Spring Data JPA (Hibernate) |
| Database | PostgreSQL (compatible with MySQL) |
| Mapping | MapStruct 1.5 |
| Boilerplate reduction | Lombok |
| API Documentation | SpringDoc OpenAPI 3.0 (Swagger UI) |
| Build Tool | Maven |

---

## Project Structure

```
src/main/java/com/hindustries/
│
├── App.java                          # Entry point
│
├── base/                             # Generic reusable base layer
│   ├── BaseController.java           # Generic CRUD controller (POST/PUT/GET/DELETE)
│   ├── BaseService.java              # Interface contract
│   ├── BaseServiceImpl.java          # Template implementation with lifecycle hooks
│   └── BaseBatchService.java         # Batch create interface
│
├── config/
│   ├── CorsConfig.java
│   └── OpenApiConfig.java
│
├── util/
│   ├── ApiResponse.java              # Unified response envelope
│   ├── Constant.java                 # Centralized resource name constants
│   ├── ResourceLabel.java            # Custom annotation for entity labeling
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
│
├── entity/
│   ├── farm/                         # 9 entities
│   ├── master/                       # 6 entities
│   ├── inventory/                    # 6 entities
│   ├── commerce/                     # 9 entities
│   ├── system/                       # 5 entities
│   └── enums/                        # AlasanAfkir, StatusKelompok
│
├── repository/      [farm | master | inventory | commerce | system]
├── service/         [farm | master | inventory | commerce | system]
├── mapper/          [farm | master | inventory | commerce | system]
├── dto/
│   ├── request/     [farm | master | inventory | commerce | system]
│   └── response/    [farm | master | inventory | commerce | system]
└── controller/      [farm | master | inventory | commerce | system]
```

---

## Getting Started

### Prerequisites

- Java 17+
- PostgreSQL 14+
- Maven 3.8+

### 1. Clone the repository

```bash
git clone https://github.com/your-username/appeggs.git
cd appeggs
```

### 2. Configure the database

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/appeggs
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run the application

```bash
mvn spring-boot:run
```

The API will start at `http://localhost:8080`.

### 4. Verify

```bash
curl http://localhost:8080/api/kandang
# → {"success":true,"message":"Successfully","data":[]}
```

---

## API Documentation

Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

The OpenAPI spec (JSON) is at:

```
http://localhost:8080/v3/api-docs
```

---

## Design Decisions

### Why a generic `BaseController` / `BaseServiceImpl`?

35 domains with standard CRUD would mean 35×5 = 175 identical method implementations. The generic base layer reduces this to zero duplication. Any domain that needs standard behavior simply extends the base. Any domain that needs custom logic (e.g. `GradingTelurService` updating stock, `KonsumsiPakanService` deducting stock) overrides only the relevant hook or method.

### Why MapStruct over manual mapping?

MapStruct generates compile-time mapping code — no reflection at runtime, no `BeanUtils.copyProperties` bugs with nested objects, and explicit `@Mapping` declarations make relation flattening readable and reviewable. The `@MappingTarget` pattern for updates means entity fields not present in the request are never accidentally nulled.

### Why `@ResourceLabel` instead of hardcoding strings?

Resource names like `"Data kelompok ayam"` appear in `ResourceNotFoundException` messages. Without centralization, a rename means searching all service files. With `@ResourceLabel` on the entity class and `Constant.*` as the source of truth, the message is defined once at the entity level and flows automatically through `BaseServiceImpl` via reflection — with zero coupling to individual service constructors.

### Why domain-scoped packages over a flat layer structure?

A flat structure (`service/KelompokAyamService.java`, `service/PesananPenjualanService.java`) works for small apps but becomes impossible to navigate at 35+ components. Domain scoping (`service/farm/`, `service/commerce/`) means adding a new feature stays contained within one domain folder — reduced cognitive load and clearer ownership boundaries.

---

## Author

Built by **[Hanif Iwansyah]**  

---

*This project is a portfolio demonstration of Spring Boot architecture patterns applied to a real-world agricultural management domain.*
