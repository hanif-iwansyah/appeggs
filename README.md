<p align="center">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Security-JWT-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"/>
  <img src="https://img.shields.io/badge/JPA_Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white"/>
  <img src="https://img.shields.io/badge/MapStruct-1.5-red?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Lombok-Boilerplate_Free-pink?style=for-the-badge"/>
</p>

<h1 align="center">🥚 AppEggs — Poultry Farm Management System</h1>

<p align="center">
  Enterprise-grade backend system for managing end-to-end operations of a poultry egg farm —<br/>
  from flock intake and health monitoring, to egg production, inventory, and sales.
</p>

---

## 📖 About The Project

**AppEggs** is a RESTful backend API built with **Spring Boot 3** designed for medium-to-large poultry (layer chicken) farm enterprises. It digitalizes and centralizes all farm operations across six major business domains into a single, maintainable system.

The system is built around a clean layered architecture using a reusable `BaseController → BaseService → JPA Repository` pattern that accelerates CRUD development while keeping custom business logic isolated per domain.

---

## 🏗️ System Architecture

```
┌────────────────────────────────────────────────────────────────┐
│                        CLIENT (Postman / Frontend)             │
└───────────────────────────────┬────────────────────────────────┘
                                │ HTTP / JSON
┌───────────────────────────────▼────────────────────────────────┐
│                  Spring Security (JWT Filter)                   │
└───────────────────────────────┬────────────────────────────────┘
                                │
┌───────────────────────────────▼────────────────────────────────┐
│                        Controller Layer                         │
│   BaseController<Req, Res, ID>   +   Custom Endpoint Methods   │
└───────────────────────────────┬────────────────────────────────┘
                                │
┌───────────────────────────────▼────────────────────────────────┐
│                         Service Layer                           │
│         BaseService Interface  +  Business Logic Impl          │
└──────────────┬────────────────────────────────┬────────────────┘
               │                                │
┌──────────────▼───────────────┐  ┌─────────────▼──────────────┐
│     JPA Repository Layer     │  │    MapStruct Mapper Layer   │
│  (Spring Data auto-queries)  │  │  (Entity ↔ DTO conversion)  │
└──────────────┬───────────────┘  └────────────────────────────┘
               │
┌──────────────▼───────────────┐
│     PostgreSQL / MySQL DB    │
└──────────────────────────────┘
```

---

## 🗂️ Domain Modules

The system is organized into **6 business domains**, each with its own package structure:

| # | Domain | Scope | Status |
|---|---------|-------|--------|
| 1 | **Master Data** | Farm, Cage, Breed, Supplier, Customer, Feed Type, User, Role | ✅ Active |
| 2 | **Flock Operations** | Flock intake, feed consumption, vaccination, disease records | 🔧 In Progress |
| 3 | **Egg Production** | Daily production, egg grading (A/B/C), HDP metrics | 🔧 In Progress |
| 4 | **Purchasing** | Purchase orders, feed procurement per supplier | 🔧 In Progress |
| 5 | **Sales** | Sales orders, egg sales, delivery, payment recording | 🔧 In Progress |
| 6 | **Inventory** | Feed stock, egg stock, medicine stock, warehouse management | 🔧 In Progress |
| + | **Reporting** | Daily & monthly farm summary reports | 🔧 In Progress |

---

## 📦 Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.x |
| Security | Spring Security + JWT |
| ORM | Spring Data JPA / Hibernate |
| DTO Mapping | MapStruct 1.5 |
| Boilerplate Reduction | Lombok |
| Validation | Jakarta Bean Validation (`@Valid`, `@NotBlank`, `@Min`) |
| Build Tool | Maven |
| Database | PostgreSQL / MySQL |

---

## 🗃️ Entity Domain Model

```
MASTER DATA
───────────
Peternakan ──< Kandang ──────────────┐
RasAyam ─────────────────────────────┤
JenisPakan                           │
Pelanggan                            │
Pemasok                              │
Pengguna >── Peran                   │
Karyawan                             │
                                     ▼
FLOCK OPERATIONS                 KelompokAyam (StatusKelompok: AKTIF/AFKIR/SELESAI)
────────────────                     │         │          │           │
                              KonsumsiPakan  KematianAyam  PengakiranAyam
                              (per JenisPakan)              (AlasanAfkir)
                                     │
                              CatatanVaksinasi ──< JadwalVaksin
                              KasusPenyakit

EGG PRODUCTION                   KelompokAyam
──────────────                       │
                              ProduksiTelur ──< GradingTelur
                              (totalTelur, telurPecah, telurAbnormal)
                              (gradeA, gradeB, gradeC)

PURCHASING                    Pemasok
──────────                       │
                          PesananPembelian
                          PembelianPakan ──< PembelianPakanDetail (per JenisPakan)

SALES                         Pelanggan
─────                            │
                          PesananPenjualan ──< PesananPenjualanDetail
                          PenjualanTelur   ──< PenjualanTelurDetail
                          Pengiriman
                          Pembayaran

INVENTORY                     Gudang
─────────                        │
                          StokPakan (per JenisPakan)
                          StokTelur (per grade)
                          StokObat
                          BarangInventaris ──< TransaksiInventaris
```

---

## 🔌 API Endpoints Overview

### Domain 1 — Master Data

| Method | Endpoint | Description |
|--------|----------|-------------|
| CRUD | `/api/peternakan` | Farm management |
| CRUD | `/api/kandang` | Cage / pen management |
| CRUD | `/api/ras-ayam` | Chicken breed registry |
| CRUD | `/api/jenis-pakan` | Feed type registry |
| CRUD | `/api/pelanggan` | Customer management |
| CRUD | `/api/pemasok` | Supplier management |
| CRUD | `/api/karyawan` | Employee management |
| CRUD | `/api/pengguna` | User account management |
| CRUD | `/api/peran` | Role management |
| CRUD | `/api/gudang` | Warehouse management |

> All master endpoints expose standard `GET /`, `GET /{id}`, `POST /`, `PUT /{id}`, `DELETE /{id}` via `BaseController`.

---

### Domain 2 — Flock Operations

| Method | Endpoint | Description |
|--------|----------|-------------|
| CRUD | `/api/kelompok-ayam` | Flock registration & lifecycle |
| `POST` | `/api/kelompok-ayam/{id}/aktivasi-kelompok` | Activate a flock |
| `POST` | `/api/kelompok-ayam/{id}/selesaikan-kelompok` | Complete / retire a flock |
| `GET` | `/api/kelompok-ayam/{id}/lihat-ringkasan-kelompok` | Live flock summary (population, age, status) |
| CRUD | `/api/konsumsi-pakan` | Daily feed consumption records |
| CRUD | `/api/jadwal-vaksin` | Vaccination schedule master |
| CRUD | `/api/catatan-vaksinasi` | Vaccination realization records |
| CRUD | `/api/kasus-penyakit` | Disease case tracking |
| CRUD | `/api/kematian-ayam` | Mortality records |
| `POST` | `/api/pengakiran-ayam/input-pengakiran` | Log chicken culling |
| `GET` | `/api/pengakiran-ayam/riwayat-pengakiran` | Full culling history |
| `GET` | `/api/pengakiran-ayam/ringkasan-pengakiran` | Culling summary stats |

---

### Domain 3 — Egg Production

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/produksi/input` | Record daily egg production |
| `GET` | `/api/produksi/harian?date=` | Daily production report |
| `GET` | `/api/produksi/bulanan?bulan=&tahun=` | Monthly production report |
| `GET` | `/api/produksi/hdp?kelompokAyamId=&dari=&sampai=` | Hen Day Production (HDP%) |
| `GET` | `/api/produksi/summary?kelompokAyamId=&dari=&sampai=` | Production summary |
| CRUD | `/api/produksi-telur` | Egg production line items |
| CRUD | `/api/grading-telur` | Egg grade classification (A/B/C) |

---

### Domain 4 — Purchasing

| Method | Endpoint | Description |
|--------|----------|-------------|
| CRUD | `/api/pesanan-pembelian` | Purchase orders to suppliers |
| CRUD | `/api/pembelian-pakan` | Feed purchase transactions |
| CRUD | `/api/pembelian-pakan-detail` | Line items per feed purchase |

---

### Domain 5 — Sales

| Method | Endpoint | Description |
|--------|----------|-------------|
| CRUD | `/api/pesanan-penjualan` | Customer sales orders |
| CRUD | `/api/pesanan-penjualan-detail` | Sales order line items |
| CRUD | `/api/penjualan-telur` | Egg sales transactions |
| CRUD | `/api/penjualan-telur-detail` | Egg sales by grade |
| CRUD | `/api/pengiriman` | Delivery management |
| CRUD | `/api/pembayaran` | Payment recording |

---

### Domain 6 — Inventory

| Method | Endpoint | Description |
|--------|----------|-------------|
| CRUD | `/api/stok-pakan` | Feed stock per warehouse |
| CRUD | `/api/stok-telur` | Egg stock per grade per warehouse |
| CRUD | `/api/stok-obat` | Medicine stock |
| CRUD | `/api/barang-inventaris` | General inventory items |
| CRUD | `/api/transaksi-inventaris` | Inventory in/out transactions |

---

### Reporting

| Method | Endpoint | Description |
|--------|----------|-------------|
| CRUD | `/api/laporan-harian` | Daily farm reports |
| CRUD | `/api/laporan-bulanan` | Monthly farm reports |

---

## 📐 Design Patterns Used

### BaseController Pattern
A generic abstract controller that auto-provides all 5 CRUD operations. Domain controllers extend it and override only when custom behavior is needed:

```java
@RestController
@RequestMapping("/api/resource")
public class ResourceController
        extends BaseController<ResourceRequest, ResourceResponse, Long> {
    @Override
    protected BaseService<ResourceRequest, ResourceResponse, Long> getService() {
        return service;
    }
    // Add custom endpoints here only if needed
}
```

### ApiResponse Wrapper
All endpoints return a consistent response envelope:
```json
{
  "success": true,
  "message": "Berhasil",
  "data": { }
}
```

### MapStruct for DTO Mapping
Zero-boilerplate conversion between JPA entities and DTOs using compile-time generated mappers:
```java
@Mapper(componentModel = "spring")
public interface KelompokAyamMapper {
    @Mapping(source = "kandang.namaKandang", target = "namaKandang")
    @Mapping(source = "ras.namaRas",         target = "namaRas")
    KelompokAyamResponse toResponse(KelompokAyam entity);
}
```

### ResourceLabel Annotation
Custom annotation on every entity for consistent resource naming across error messages and logging:
```java
@ResourceLabel(Constant.KELOMPOK_AYAM)
public class KelompokAyam { ... }
```

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+
- PostgreSQL 14+ or MySQL 8+

### Setup

```bash
# 1. Clone the repository
git clone https://github.com/hanif-iwansyah/appeggs.git
cd appeggs

# 2. Configure database in application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/appeggs_db
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

# 3. Build and run
mvn clean install
mvn spring-boot:run

# 4. API available at
http://localhost:8080
```

---

## 🔐 Security

- JWT-based stateless authentication
- Role-based access control (`Peran` entity linked to `Pengguna`)
- All endpoints protected; auth endpoints public
- Spring Security `SecurityFilterChain` with `SessionCreationPolicy.STATELESS`

---

## 📁 Package Structure

```
com.hindustries
├── base/               ← BaseController, BaseService
├── controller/
│   ├── domain/
│   │   ├── master/     ← Master data controllers
│   │   ├── operasional/← Flock operations
│   │   ├── pembelian/  ← Purchasing
│   │   └── penjualan/  ← Sales
│   ├── domain_operasional_peternakan/
│   │   ├── kesehatan_ayam/ ← Health & vaccination
│   │   └── produksi/   ← Egg production
│   └── domain_persediaan/  ← Inventory
├── dto/
│   ├── request/        ← Input DTOs per domain
│   └── response/       ← Output DTOs per domain
├── entity/
│   ├── commerce/       ← Sales & purchasing entities
│   ├── farm/           ← Flock & production entities
│   ├── inventory/      ← Stock & warehouse entities
│   ├── master/         ← Reference data entities
│   └── system/         ← User, role, report entities
├── mapper/             ← MapStruct mappers per domain
├── service/            ← Business logic per domain
└── util/               ← ApiResponse, Constant, ResourceLabel
```

---

##  Author

**Hanif Iwansyah**  
Backend Developer · Java Spring Boot  
[GitHub](https://github.com/hanif-iwansyah)

---

<p align="center">Built with ☕ Java & 🌱 Spring Boot</p>
