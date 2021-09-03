package IO;

public class StandardInputAndOutput {
    public static void main(String[] args) {
        //System.in 编译类型：InputStream
        //System.in 运行类型：BufferedInputStream
        System.out.println(System.in.getClass());

        //System.out 编译类型和运行类型都是 PrintStream
        System.out.println(System.out.getClass());
    }
}
