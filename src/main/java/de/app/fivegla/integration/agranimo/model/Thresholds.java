package de.app.fivegla.integration.agranimo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Thresholds {
    private int[] domain;
    private int upper;
    private int lower;
}
