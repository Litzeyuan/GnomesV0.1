package gnomes.spring.gnomesv01.models;


public class GerminationStage extends BaseEntity{

    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
