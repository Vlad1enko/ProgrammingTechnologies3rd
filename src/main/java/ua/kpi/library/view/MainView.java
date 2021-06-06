package ua.kpi.library.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "")
@PageTitle("Hello World")
public class MainView extends Div {

    public MainView() {
        setText("Hello world");
    }

}
