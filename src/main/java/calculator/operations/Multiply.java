package calculator.operations;

import calculator.ImpleCalculate;

public class Multiply  implements ImpleCalculate {
    @Override
    public int executeOperation(int input1, int input2) {
        return input1 * input2;
    }
}
