package dev.estudo.managerFoot.Entity;

public enum Position {

    GOALKEEPER("Goalkeeper"),
    DEFENDER("Defender"),
    FULLBACK("Fullback"),
    MIDFIELDER("Midfielder"),
    FORWARD("Forward");

    private final String label;

    Position(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
