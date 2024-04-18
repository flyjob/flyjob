package az.rock.flyjob.js.dataaccess.repository.abstracts.query.batis;

import az.rock.flyjob.js.dataaccess.model.batis.model.ContactCompose;
import az.rock.flyjob.js.dataaccess.model.batis.model.ContactComposeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactBatisRepository {
    long countByExample(ContactComposeExample example);

    int deleteByExample(ContactComposeExample example);

    int deleteByPrimaryKey(Object uuid);

    int insert(ContactCompose record);

    int insertSelective(ContactCompose record);

    List<ContactCompose> selectByExample(ContactComposeExample example);

    ContactCompose selectByPrimaryKey(Object uuid);

    int updateByExampleSelective(@Param("record") ContactCompose record, @Param("example") ContactComposeExample example);

    int updateByExample(@Param("record") ContactCompose record, @Param("example") ContactComposeExample example);

    int updateByPrimaryKeySelective(ContactCompose record);

    int updateByPrimaryKey(ContactCompose record);
}