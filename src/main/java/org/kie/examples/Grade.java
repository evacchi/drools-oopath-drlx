package org.kie.examples;

public class Grade {

    private int result;
    private boolean laude;

    public Grade(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setLaude() {
        this.laude = true;
    }
}
