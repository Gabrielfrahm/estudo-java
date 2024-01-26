package out.persistence.task;

public class SearchTaskParams {
    private Integer page;
    private Integer perPage;
    private String name;
    private String description;

    public void SearchTaskParams(Integer page, Integer perPage, String name, String description) {
        this.page = page;
        this.perPage = perPage;
        this.name = name;
        this.description = description;
    }
    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
