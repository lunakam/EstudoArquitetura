package io.github.lunakam.estudoarquitetura.stepsDefinition.components;

import io.github.lunakam.estudoarquitetura.drivers.WebDriverContext;
import io.github.lunakam.estudoarquitetura.pageObjects.BaseComponent;
import lombok.Getter;

@Getter
public class AntdComponent extends BaseComponent {

    private final DropdownComponent dropdown;

    private final SelectComponent select;

    private final InputComponent input;

    private final ButtonComponent button;

    private final RadioComponent radio;

    private final CrudTableList crudTableList;

    public AntdComponent(WebDriverContext webDriverContext) {
        super(webDriverContext);
        this.dropdown = new DropdownComponent(webDriverContext);
        this.select = new SelectComponent(webDriverContext);
        this.input = new InputComponent(webDriverContext);
        this.button = new ButtonComponent(webDriverContext);
        this.radio = new RadioComponent(webDriverContext);
        this.crudTableList = new CrudTableList(webDriverContext);
    }


}
