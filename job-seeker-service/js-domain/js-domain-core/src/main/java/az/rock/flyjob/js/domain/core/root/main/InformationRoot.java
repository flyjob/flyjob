package az.rock.flyjob.js.domain.core.root.main;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.InformationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;
import java.util.List;

public class InformationRoot extends AggregateRoot<InformationID> {

    private ResumeID resume;

    private String name;

    private String surname;

    private Gender gender;

    private JobTitleInformationRoot jobTitleInformation;

    private ZonedDateTime birthDate;

    private String nationality;

    private String passport;

    private String maritalStatus;

    private String militaryService;

    private String drivingLicense;

    private List<LinkRoot> links;

    private AddressRoot address;

    private InformationRoot(Builder builder) {
        super(builder.id, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        resume = builder.resume;
        name = builder.name;
        surname = builder.surname;
        gender = builder.gender;
        jobTitleInformation = builder.jobTitleInformation;
        birthDate = builder.birthDate;
        nationality = builder.nationality;
        passport = builder.passport;
        maritalStatus = builder.maritalStatus;
        militaryService = builder.militaryService;
        drivingLicense = builder.drivingLicense;
        links = builder.links;
        address = builder.address;
    }


    public ResumeID getResume() {
        return resume;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public JobTitleInformationRoot getJobTitleInformation() {
        return jobTitleInformation;
    }

    public ZonedDateTime getBirthDate() {
        return birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPassport() {
        return passport;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getMilitaryService() {
        return militaryService;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public List<LinkRoot> getLinks() {
        return links;
    }

    public AddressRoot getAddress() {
        return address;
    }

    public static final class Builder {
        private InformationID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private ResumeID resume;
        private String name;
        private String surname;
        private Gender gender;
        private JobTitleInformationRoot jobTitleInformation;
        private ZonedDateTime birthDate;
        private String nationality;
        private String passport;
        private String maritalStatus;
        private String militaryService;
        private String drivingLicense;
        private List<LinkRoot> links;
        private AddressRoot address;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(InformationID val) {
            id = val;
            return this;
        }

        public Builder version(Version val) {
            version = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder rowStatus(RowStatus val) {
            rowStatus = val;
            return this;
        }

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(ZonedDateTime val) {
            lastModifiedDate = val;
            return this;
        }

        public Builder resume(ResumeID val) {
            resume = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder surname(String val) {
            surname = val;
            return this;
        }

        public Builder gender(Gender val) {
            gender = val;
            return this;
        }

        public Builder jobTitleInformation(JobTitleInformationRoot val) {
            jobTitleInformation = val;
            return this;
        }

        public Builder birthDate(ZonedDateTime val) {
            birthDate = val;
            return this;
        }

        public Builder nationality(String val) {
            nationality = val;
            return this;
        }

        public Builder passport(String val) {
            passport = val;
            return this;
        }

        public Builder maritalStatus(String val) {
            maritalStatus = val;
            return this;
        }

        public Builder militaryService(String val) {
            militaryService = val;
            return this;
        }

        public Builder drivingLicense(String val) {
            drivingLicense = val;
            return this;
        }

        public Builder links(List<LinkRoot> val) {
            links = val;
            return this;
        }

        public Builder address(AddressRoot val) {
            address = val;
            return this;
        }

        public InformationRoot build() {
            return new InformationRoot(this);
        }
    }
}
