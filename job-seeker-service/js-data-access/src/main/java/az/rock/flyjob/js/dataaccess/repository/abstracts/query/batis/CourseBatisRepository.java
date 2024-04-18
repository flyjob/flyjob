package az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis;

import az.rock.flyjob.js.dataaccess.model.batis.model.CourseCompose;
import az.rock.flyjob.js.dataaccess.model.batis.model.CourseComposeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseBatisRepository {
    long countByExample(CourseComposeExample example);

    int deleteByExample(CourseComposeExample example);

    int deleteByPrimaryKey(Object uuid);

    int insert(CourseCompose record);

    int insertSelective(CourseCompose record);

    List<CourseCompose> selectByExample(CourseComposeExample example);

    CourseCompose selectFirstByExample(CourseComposeExample example);

    CourseCompose selectByPrimaryKey(Object uuid);

    int updateByExampleSelective(@Param("record") CourseCompose record, @Param("example") CourseComposeExample example);

    int updateByExample(@Param("record") CourseCompose record, @Param("example") CourseComposeExample example);

    int updateByPrimaryKeySelective(CourseCompose record);

    int updateByPrimaryKey(CourseCompose record);
}