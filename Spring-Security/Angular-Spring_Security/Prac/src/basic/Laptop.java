package basic;

public class Laptop {

    String laptopName;
    String processor;

    String modelNo;

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopName='" + laptopName + '\'' +
                ", processor='" + processor + '\'' +
                ", modelNo='" + modelNo + '\'' +
                '}';
    }

    public Laptop(String laptopName, String processor, String modelNo){
        this.laptopName = laptopName;
        this.modelNo = modelNo;
        this.processor = processor;
    }
}
