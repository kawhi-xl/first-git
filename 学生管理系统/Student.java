public class Student {
    private String id;//ѧ��
    private String name;//����
    private String cellphone;//�绰����
    Student(){

    }
    Student(String id,String name,String cellphone){
        this.id=id;
        this.name=name;
        this.cellphone=cellphone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public String toString() {
        return id+","+name+","+cellphone;
    }
}
