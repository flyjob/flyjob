package az.rock.flyjob.js.dataaccess.mapper.concretes;

import az.rock.flyjob.js.dataaccess.mapper.abstracts.AbstractPageableDataAccessMapper;
import az.rock.lib.valueObject.SimplePageableRequest;
import com.intellibucket.lib.fj.dataaccess.BatisPageable;
import org.springframework.stereotype.Component;

@Component
public class PageableDataAccessMapper implements AbstractPageableDataAccessMapper {

    @Override
    public BatisPageable toBatisPageable(SimplePageableRequest pageableRequest) {
        return BatisPageable.of(pageableRequest.getSize(), pageableRequest.getPage());
    }
}
