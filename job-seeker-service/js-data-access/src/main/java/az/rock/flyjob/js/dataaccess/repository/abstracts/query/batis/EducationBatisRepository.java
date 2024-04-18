package az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis;

import az.rock.flyjob.js.dataaccess.model.batis.model.EducationCompose;
import az.rock.flyjob.js.dataaccess.model.batis.model.EducationComposeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EducationBatisRepository {
    long countByExample(EducationComposeExample example);

    int deleteByExample(EducationComposeExample example);

    int deleteByPrimaryKey(Object uuid);

    int insert(EducationCompose record);

    int insertSelective(EducationCompose record);

    List<EducationCompose> selectByExample(EducationComposeExample example);

    EducationCompose selectByPrimaryKey(Object uuid);

    int updateByExampleSelective(@Param("record") EducationCompose record, @Param("example") EducationComposeExample example);

    int updateByExample(@Param("record") EducationCompose record, @Param("example") EducationComposeExample example);

    int updateByPrimaryKeySelective(EducationCompose record);

    int updateByPrimaryKey(EducationCompose record);
}