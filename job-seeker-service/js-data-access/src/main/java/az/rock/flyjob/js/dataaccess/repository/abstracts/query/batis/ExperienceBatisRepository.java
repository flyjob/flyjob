package az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis;

import az.rock.flyjob.js.dataaccess.model.batis.model.CourseCompose;
import az.rock.flyjob.js.dataaccess.model.batis.model.CourseComposeExample;
import az.rock.flyjob.js.dataaccess.model.batis.model.ExperienceCompose;
import az.rock.flyjob.js.dataaccess.model.batis.model.ExperienceComposeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExperienceBatisRepository {
    long countByExample(ExperienceComposeExample example);

    int deleteByExample(ExperienceComposeExample example);

    int deleteByPrimaryKey(Object uuid);

    int insert(ExperienceCompose record);

    int insertSelective(ExperienceCompose record);

    List<ExperienceCompose> selectByExample(ExperienceComposeExample example);
    ExperienceCompose selectFirstByExample(ExperienceComposeExample example);

    ExperienceCompose selectByPrimaryKey(Object uuid);

    int updateByExampleSelective(@Param("record") ExperienceCompose record, @Param("example") ExperienceComposeExample example);

    int updateByExample(@Param("record") ExperienceCompose record, @Param("example") ExperienceComposeExample example);

    int updateByPrimaryKeySelective(ExperienceCompose record);

    int updateByPrimaryKey(ExperienceCompose record);
}
