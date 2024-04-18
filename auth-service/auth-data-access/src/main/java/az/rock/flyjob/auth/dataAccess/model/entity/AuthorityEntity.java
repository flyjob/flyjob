package az.rock.flyjob.auth.dataAccess.model.entity;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

/**
 * Example 1
 * - Permission *.auth.account.public.read
 * - Bütün istifadəçilərin profillərinə baxa bilmək
 * Example 2
 * - Permission *.auth.account.private.read
 * - Bütün istifadəçilərin profillərinə və şəxsi məlumatlarına baxa bilmək
 * Example 3
 * - Permission own.auth.account.private.read
 * - İstifadəçinin öz profil məlumatlarına detallı baxa bilməsi
 * Example 3
 * - Permission *.user.post.public.read
 * - Bütün istifadəçilərin postlarına baxa bilmək
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authorities", schema = "auth")
@Entity(name = "AuthorityEntity")
public class AuthorityEntity extends BaseEntity {
    @Column(name = "permission", nullable = false, unique = true)
    private String permission;


    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "authorities")
    private Set<RoleEntity> roles;

    private AuthorityEntity(Builder builder) {
        setPermission(builder.permission);
        setDescription(builder.description);
        setRoles(builder.roles);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private String permission;
        private String description;
        private Set<RoleEntity> roles;
        private UUID uuid;
        private Long version;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private ProcessStatus processStatus;

        private RowStatus rowStatus;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder permission(String val) {
            permission = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder roles(Set<RoleEntity> val) {
            roles = val;
            return this;
        }

        public Builder uuid(UUID val) {
            uuid = val;
            return this;
        }

        public Builder version(Long val) {
            version = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder dataStatus(RowStatus val) {
            rowStatus = val;
            return this;
        }

        public Builder createdDate(Timestamp val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(Timestamp val) {
            lastModifiedDate = val;
            return this;
        }

        public AuthorityEntity build() {
            return new AuthorityEntity(this);
        }
    }
}
