package az.rock.flyjob.js.dataaccess.adapter.query.detail;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractInterestDataAccessMapper;
import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractPageableDataAccessMapper;
import az.rock.flyjob.js.dataaccess.model.batis.model.InterestCompose;
import az.rock.flyjob.js.dataaccess.model.batis.model.InterestComposeExample;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis.InterestBatisRepository;
import az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa.AbstractInterestQueryJPARepository;
import az.rock.flyjob.js.domain.core.exception.interest.InterestOverLimit;
import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import az.rock.flyjob.js.domain.presentation.dto.criteria.InterestCriteria;

import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractInterestQueryRepositoryAdapter;
import az.rock.lib.domain.id.js.InterestID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.SimplePageableRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Component
public class InterestQueryRepositoryAdapter implements AbstractInterestQueryRepositoryAdapter {

    private final InterestBatisRepository batisRepository;
    private final AbstractInterestQueryJPARepository repository;
    private final AbstractInterestDataAccessMapper interestDataAccessMapper;

    private final AbstractPageableDataAccessMapper pageableDataAccessMapper;

    public InterestQueryRepositoryAdapter(InterestBatisRepository batisRepository, AbstractInterestQueryJPARepository repository, AbstractInterestDataAccessMapper interestDataAccessMapper, AbstractPageableDataAccessMapper abstractPageableDataAccessMapper) {
        this.batisRepository = batisRepository;
        this.repository = repository;
        this.interestDataAccessMapper = interestDataAccessMapper;
        this.pageableDataAccessMapper = abstractPageableDataAccessMapper;
    }


    @Override
    public Optional<InterestRoot> fetchAnyById(InterestCriteria interestCriteria) {
        var interestComposeExample = InterestComposeExample.of(interestCriteria);
        var interestCompose = this.batisRepository.selectFirstByExample(interestComposeExample);
        if (interestCompose.isPresent()) {
            return this.interestDataAccessMapper.toRoot(interestCompose.get());
        }
        return Optional.empty();
    }


    @Override
    public List<InterestRoot> fetchAllAnySimpleInterest(InterestCriteria criteria, SimplePageableRequest request) throws InterestOverLimit {
        var interestComposeExample = InterestComposeExample.of(criteria);
        interestComposeExample.addPageable(pageableDataAccessMapper.toBatisPageable(request));

        final List<InterestCompose> interestComposes = this.batisRepository.selectByExample(interestComposeExample);
        if (!interestComposes.isEmpty()) {
            return interestComposes.stream()
                    .map(interestDataAccessMapper::toRoot)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

        }
        return List.of();

    }

    @Override
    public List<InterestRoot> fetchAllAnyInterests(InterestCriteria criteria, SimplePageableRequest request) throws InterestOverLimit {
        InterestComposeExample interestComposeExample = InterestComposeExample.of(criteria);
        interestComposeExample.addPageable(pageableDataAccessMapper.toBatisPageable(request));

        final List<InterestCompose> interestComposes = this.batisRepository.selectByExample(interestComposeExample);
        if (!interestComposes.isEmpty()) {
            return interestComposes.stream()
                    .map(interestDataAccessMapper::toRoot)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();


        }
        return List.of();
    }


    @Override
    public Optional<InterestRoot> findMyInterestById(InterestCriteria criteria) {
        InterestComposeExample interestComposeExample = InterestComposeExample.of(criteria);

        var interestCompose = batisRepository.selectFirstByExample(interestComposeExample);
        if (interestCompose.isPresent()) {
            return this.interestDataAccessMapper.toRoot(interestCompose.get());
        }
        return Optional.empty();
    }

        @Override
        public List<InterestRoot> queryAllMyInterests (InterestCriteria criteria, SimplePageableRequest request) throws InterestOverLimit {
            InterestComposeExample interestComposeExample = InterestComposeExample.of(criteria);
            interestComposeExample.addPageable(pageableDataAccessMapper.toBatisPageable(request));

            return batisRepository.selectByExample(interestComposeExample)
                    .stream()
                    .map(interestDataAccessMapper::toRoot)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

        }

        @Override
        public List<InterestRoot> queryAllMySimpleInterests (InterestCriteria criteria, SimplePageableRequest request) throws
        InterestOverLimit {
            InterestComposeExample interestComposeExample = InterestComposeExample.of(criteria);
            interestComposeExample.addPageable(pageableDataAccessMapper.toBatisPageable(request));

            return batisRepository.selectByExample(interestComposeExample)
                    .stream()
                    .map(interestDataAccessMapper::toRoot)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();
        }

        @Override
        public Optional<InterestRoot> findOwnByID (ResumeID parentID, InterestID
        rootId, List < AccessModifier > accessModifiers){
            var entity = repository.findByResumeAndInterestId(parentID.getAbsoluteID(), rootId.getAbsoluteID(), accessModifiers);
            if (entity.isEmpty()) return Optional.empty();
            return this.interestDataAccessMapper.toRoot(entity.get());
        }

        @Override
        public Optional<InterestRoot> findById (InterestID rootId){
            var entity = repository.findById(rootId);
            if (entity.isEmpty()) return Optional.empty();
            return this.interestDataAccessMapper.toRoot(entity.get());
        }


        @Override
        public List<InterestRoot> findAllByPID (ResumeID parentID, List < AccessModifier > modifierList){
            var allByResumeID = repository.findAllByResumeID(parentID.getAbsoluteID(), modifierList);
            return allByResumeID.stream()
                    .map(this.interestDataAccessMapper::toRoot)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();
        }

        @Override
        public Optional<Integer> getLimit (ResumeID resumeID){
            final Optional<Integer> interestCount = repository.limitCount(resumeID.getAbsoluteID());
            if (interestCount.isPresent()) {
                return interestCount;
            }
            return Optional.empty();
        }


    }
