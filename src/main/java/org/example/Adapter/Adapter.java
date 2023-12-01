package org.example.Adapter;

class OldSystem {
    public String request() {
        return "Old System Request";
    }
}

class NewSystem {
    public String specificRequest() {
        return "New System Request";
    }
}

class Adapter extends OldSystem {
    private final NewSystem newSystem;

    public Adapter() {
        this.newSystem = new NewSystem();
    }

    @Override
    public String request() {
        return newSystem.specificRequest();
    }
}

class AdapterTest {
    public static void main(String[] args) {
        OldSystem oldSystem = new OldSystem();
        System.out.println(oldSystem.request());

        Adapter adapter = new Adapter();
        System.out.println(adapter.request());
    }
}
