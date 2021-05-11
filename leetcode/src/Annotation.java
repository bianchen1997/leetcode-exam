import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class Annotation {

    public static void main(String[] args) throws NoSuchFieldException {
        Class<Student> studentClass = Student.class;

        ClassAnnotation annotation = studentClass.getAnnotation(ClassAnnotation.class);
        System.out.println(annotation.value());

        Field declaredField = studentClass.getDeclaredField("id");

        FieldAnnotation fieldAnnotation = declaredField.getAnnotation(FieldAnnotation.class);

        System.out.println(fieldAnnotation.columnName());
        System.out.println(fieldAnnotation.length());
        System.out.println(fieldAnnotation.type());

    }
}

@ClassAnnotation("student")
class Student{
    @FieldAnnotation(columnName = "id", type = "int", length = 10)
    private int id;

    @FieldAnnotation(columnName = "name", type = "varchar", length = 10)
    private int name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ClassAnnotation{
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface FieldAnnotation{
    String columnName();
    String type();
    int length();
}


