package cn.jiayuli.polymorphism;

public class Parent {
    public String say(Parent obj){
        return "Parent and Parent";
    }
    public String say(Granddaughter obj){
        return "Parent and Granddaughter";
    }
    public static void main(String[] args){
        Parent parentA = new Parent();
        Parent parentB = new Children();
        Children children = new Children();
        Grandson grandson = new Grandson();
        Granddaughter granddaughter = new Granddaughter();

        System.out.println("1--" + parentA.say(children));
        System.out.println("2--" + parentA.say(grandson));
        System.out.println("3--" + parentA.say(granddaughter));
        System.out.println("4--" + parentB.say(children));
        System.out.println("5--" + parentB.say(grandson));
        System.out.println("6--" + parentB.say(granddaughter));
        System.out.println("7--" + children.say(children));
        System.out.println("8--" + children.say(grandson));
        System.out.println("9--" + children.say(granddaughter));
    }
}

class Children extends Parent{
    public String say(Parent obj){
        return "Children and Parent";
    }
    public String say(Children obj){
        return "Children and Children";
    }
}

class Grandson extends Children{
}

class Granddaughter extends Children{
}