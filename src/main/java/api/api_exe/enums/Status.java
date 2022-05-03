package api.api_exe.enums;

public enum Status {
    SUCCESS(1),  
    WARNING(2),  
    ERROR(3);    

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
