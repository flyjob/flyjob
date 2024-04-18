package az.rock.flyjob.js.domain.presentation.dto.request.abstracts;

public class CreateRequest<T extends AbstractCommandModel> {
    private T model;

    public CreateRequest(T model) {
        this.model = model;
    }

    public CreateRequest() {
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

}
