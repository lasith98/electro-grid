package lk.sliit.maintenancesectionservice.Model;

public class MainteinenceModel {
    private Integer ID;
    private String description;
    private String affected_Area;
    private String affected_time;
    private String predicted_time;

    @Override
    public String toString() {
        return "MainteinenceModel{" +
                "ID=" + ID +
                ", description='" + description + '\'' +
                ", affected_Area='" + affected_Area + '\'' +
                ", affected_time='" + affected_time + '\'' +
                ", predicted_time='" + predicted_time + '\'' +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAffected_Area() {
        return affected_Area;
    }

    public void setAffected_Area(String affected_Area) {
        this.affected_Area = affected_Area;
    }

    public String getAffected_time() {
        return affected_time;
    }

    public void setAffected_time(String affected_time) {
        this.affected_time = affected_time;
    }

    public String getPredicted_time() {
        return predicted_time;
    }

    public void setPredicted_time(String predicted_time) {
        this.predicted_time = predicted_time;
    }


}
