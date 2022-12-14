package calculator.operations;

import calculator.ImpleCalculate;

public class Subtract   implements ImpleCalculate{

    @Override
    public int executeOperation(int input1, int input2) {
        return input1 - input2;
    }
}
