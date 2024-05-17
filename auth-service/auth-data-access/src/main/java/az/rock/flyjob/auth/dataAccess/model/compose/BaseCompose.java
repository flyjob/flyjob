package az.rock.flyjob.auth.dataAccess.model.compose;

import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import com.intellibucket.lib.fj.dataaccess.annotations.Compose;

import java.sql.Timestamp;
import java.util.UUID;

@Compose
public class BaseCompose {

    private UUID uuid;

    private Long version;

    private ProcessStatus processStatus;

    private RowStatus rowStatus;

    private Timestamp createdDate;

    private Timestamp lastModifiedDate;

    public BaseCompose(UUID uuid,
                       Long version,
                       ProcessStatus processStatus,
                       RowStatus rowStatus,
                       Timestamp createdDate,
                       Timestamp lastModifiedDate) {
        this.uuid = uuid;
        this.version = version;
        this.processStatus = processStatus;
        this.rowStatus = rowStatus;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public BaseCompose() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(ProcessStatus processStatus) {
        this.processStatus = processStatus;
    }

    public RowStatus getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatus rowStatus) {
        this.rowStatus = rowStatus;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
