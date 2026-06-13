package com.hindustries.base;

import com.hindustries.util.ResourceLabel;
import com.hindustries.util.ResourceNotFoundException;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseServiceImpl<Entity, Req, Res, ID> implements BaseService<Req, Res, ID> {
    protected abstract JpaRepository<Entity, ID> getRepository();
    protected abstract Res mapToResponse(Entity entity);
    protected abstract Entity mapToEntity(Req request);
    protected abstract void updateEntityFromReq(Req request, Entity entity);

    protected void beforeCreate(Req req, Entity entity) {}
    protected void beforeUpdate(Req req, Entity entity) {}

    private final String resourceLabel;

    public BaseServiceImpl() {
        Class<?> entityClass = GenericTypeResolver.resolveTypeArgument(getClass(), BaseServiceImpl.class);
        assert entityClass != null;
        if (entityClass.isAnnotationPresent(ResourceLabel.class)) {
            this.resourceLabel = entityClass.getAnnotation(ResourceLabel.class).value();
        } else {
            this.resourceLabel = entityClass.getSimpleName();
        }
    }

    @Override
    public Res create(Req request) {
        Entity entity = mapToEntity(request);
        Entity savedEntity = getRepository().save(entity);
        return mapToResponse(savedEntity);
    }

    @Override
    public Res update(ID id, Req request) {
        Entity entity = getRepository().findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.resourceLabel, id));
        return mapToResponse(entity);
    }

    @Override
    public List<Res> findAll() {
        return getRepository().findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Res findById(ID id) {
        Entity entity = getRepository().findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.resourceLabel, id));
        return mapToResponse(entity);
    }

    @Override
    public void delete(ID id) {
        if (!getRepository().existsById(id)) {
            throw new ResourceNotFoundException(resourceLabel, id);
        }
        getRepository().deleteById(id);
    }


}
