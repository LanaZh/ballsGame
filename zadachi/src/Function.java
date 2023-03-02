public class Function {

    public static void main(String[] args) {

        byte[] num1 = new byte[]{2, 3, 5, 7};
        setFunction("sss.dldl");
        summa(2, 5);
    }

    //Функции (Методы)
    public static void setFunction(String world) {
        System.out.println(world);
    }

    public static void summa(int s, int c) {
        int res = s + c;
        System.out.println("result " + res);
    }

}