import java.lang.reflect.Field;

public class Polo {

    @Range(10)
    public String name;
    public int age;

    public void show(){
        System.out.println(this.name);
    }

    public void setName(String name){
        try {
            this.name = name;
            this.check(this);
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public void showAge(){
        System.out.println(this.age);
    }

    private void check(Polo polo) throws Exception{
        Class polocls = Polo.class;
        Field[] fields = polocls.getFields();
        for (Field field : fields) {
            Range range = field.getAnnotation(Range.class);
            if(range != null && (field.getType() == String.class)){
                String value = (String) field.get(polo);
                if(value.length() < range.value()){
                    System.out.println("not ok !!!!!!");
                }
            }
        }
    }
}
