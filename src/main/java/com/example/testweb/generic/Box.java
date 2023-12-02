package com.example.testweb.generic;

public class Box<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("{t:").append(t);
        sb.append('}');
        return sb.toString();
    }
}
