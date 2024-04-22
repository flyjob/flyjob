package az.rock.flyjob.js.dataaccess.mapper.abstracts;

import az.rock.lib.valueObject.SimplePageableRequest;
import com.intellibucket.lib.fj.dataaccess.BatisPageable;

public interface AbstractPageableDataAccessMapper {

    BatisPageable toBatisPageable(SimplePageableRequest pageableRequest);
}
