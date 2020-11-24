package com.tw;

public class MultiplicationTable {

    public String create(int startNumber, int endNumber) {
        if (isInputValid(startNumber, endNumber)) return createMultiplicationTable(startNumber, endNumber);
        return null;
    }

    private boolean isInputValid(int startNumber, int endNumber) {
        boolean isStartNotGreaterThanEnd = isStartNotGreaterThanEnd(startNumber, endNumber);
        boolean isStartNumberInRange = isNumberInRange(startNumber);
        boolean isEndNumberInRange = isNumberInRange(endNumber);

        return isStartNotGreaterThanEnd && isStartNumberInRange && isEndNumberInRange;
    }

    private boolean isNumberInRange(int number) {
        return number >= 1 && number <= 1000;
    }

    private boolean isStartNotGreaterThanEnd(int startNumber, int endNumber) {
        return endNumber >= startNumber;
    }


    private String createMultiplicationTable(int startNumber, int endNumber) {
        String multiplicationTable = "";

        for (int row = startNumber; row <= endNumber; row++) {

            for (int multiplier = startNumber; multiplier < row; multiplier++) {
                multiplicationTable += createExpression(multiplier, row) + "  ";
            }

            multiplicationTable += createExpression(row, row);

            if (row < endNumber) multiplicationTable += "\r\n";
        }

        return multiplicationTable;
    }

    private String createExpression(int multiplier, int multiplicand) {
        return multiplier + "*" + multiplicand + "=" + multiplicand * multiplier;
    }
}
