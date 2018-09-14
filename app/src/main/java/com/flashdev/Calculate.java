package com.flashdev;

public class Calculate {
//    public static void main(String[] args) {
//        // An equation with +, -, /, *
//        String anotherEquation = "1*5*4+8*9+16/8-9"; // 85
//        double another = computeAnother(anotherEquation);
//        System.out.println(another);
//    }

    public static double exe(String exp) {
        double another = computeAnother(exp);
        return another;
    }

    static double computeAnother(String equation) {
        double result = 0.0;
        String noMinus = equation.replace("-", "+-");
        String[] byPluses = noMinus.split("\\+");

        for (String multipl : byPluses) {
            String[] byMultipl = multipl.split("\\*");
            double multiplResult = 1.0;
            for (String operand : byMultipl) {
                if (operand.contains("/")) {
                    String[] division = operand.split("\\/");
                    double divident = Double.parseDouble(division[0]);
                    for (int i = 1; i < division.length; i++) {
                        divident /= Double.parseDouble(division[i]);
                    }
                    multiplResult *= divident;
                } else {
                    multiplResult *= Double.parseDouble(operand);
                }
            }
            result += multiplResult;
        }
        return result;
    }
}
