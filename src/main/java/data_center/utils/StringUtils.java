package data_center.utils;

public class StringUtils {

    public static String cleanString(String s){
        return s.trim().replaceAll("-", "").replaceAll("\\.", "").replaceAll("/", "");
    }

    public static Long cpfToLong(String cpf) {
        if (isValidCpf(cpf)){
            cpf = cleanString(cpf);
            return Long.parseLong(cpf);
        } else {
            return null;
        }
    }


    public static boolean isValidCpf(String cpf){
        String cpfRegex = "^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$";
        return cpf.matches(cpfRegex);
    }

}
