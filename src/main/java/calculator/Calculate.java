package calculator;

import lombok.Data;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Calculate {

    private static String className;
    private static int input1;
    private static int input2;
    private static final String packageName = "calculator.operations";
    public Calculate(String className, int input1, int input2){
        this.className = className;
        this.input1 = input1;
        this.input2 = input2;
    }
    Calculate(){
        Set<String> set =getSubClasses(packageName );
        System.out.println("All class are  "+ set);
        mapCalculator(set);
    }

    private static final HashMap<String,String > CLASS_OPERATION_MAP = new HashMap<>();

    public static void main(String[] args){
        System.out.println("This is calculator program");
        Calculate calculate = new Calculate("Multiply", 3 , 4);
        calculate.execute();
    }

    private static Set<String> getSubClasses(String packageName) {
        try{
            InputStream inputStream = ClassLoader.getSystemClassLoader().
                    getResourceAsStream(packageName.replaceAll("[.]", "/"));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            Set<String> set =bufferedReader.lines().filter(line -> line.endsWith(".class"))
                                    .map( line -> line.substring(0 , line.lastIndexOf(".")) )
                                    .collect(Collectors.toSet());
            bufferedReader.close();
            return set;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

        return null;
    }

    private static Class getClass(String className, String packageName){
        System.out.println("Class name "+className);
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            System.out.println("Exception "+e.getMessage());
        }
        return null;
    }

    private static void mapCalculator( Set<String> classes ){
            classes.stream().map(obj -> CLASS_OPERATION_MAP.put(obj, obj) );
        return;
    }

    public int execute(){
        try{
            Class classObj = Class.forName(packageName+"."+className);
            ImpleCalculate calculate = (ImpleCalculate) classObj.newInstance();
            int output = calculate.executeOperation(input1,input2);
            System.out.println("Output : "+ output);
            return output;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return 0;
    }

}