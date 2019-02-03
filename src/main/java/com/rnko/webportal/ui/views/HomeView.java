package com.rnko.webportal.ui.views;

import com.rnko.webportal.ui.MainWebportalView;

import com.rnko.webportal.ui.components.PaperButton;
import com.rnko.webportal.ui.components.PaperInput;
import com.rnko.webportal.ui.utils.JiraServer;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.router.Route;
import rx.subjects.ReplaySubject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.*;


@Route(value = "", layout = MainWebportalView.class)
@Tag("main-view")
@HtmlImport("src/views/main-view.html")
public class HomeView extends Div  {
    @Id("content")
    private Div content;

    /*public void setContent(Component content) {
        this.content.removeAll();
        this.content.add(content);
        HomeView page = new HomeView();
        page.setContent(new Label("Hello!"));
    }*/
    private ExecutorService service = Executors.newFixedThreadPool(1);
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);



    public HomeView() {

        JiraServer jiraServer = new JiraServer("D:\\Project\\new\\jira-test", "D:\\start.bat");
        String serverStatus = "Offline";
        try {
            serverStatus = jiraServer.CheckStatusServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Label statusServerJira = new Label();

        statusServerJira.setText("Jira server is - " + serverStatus);



        Button button_1 = new Button("Start jira server", event -> {

            service.execute(() -> {
                try {
                    jiraServer.StartServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        });


        Button button_2 = new Button("Check status", event -> {

            try {
                statusServerJira.setText("Jira server is - " + jiraServer.CheckStatusServer());
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*ReplaySubject<String> results = ReplaySubject.create();
            Runnable task = () -> {
                try {
                    jiraServer.CheckStatusServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            executor.scheduleWithFixedDelay(task, 0, 3, TimeUnit.SECONDS);
            results.forEach(result ->  statusServerJira.setText(result));*/
        });

        Button button_3 = new Button("Stop server jira", event -> {
            try {
                jiraServer.StopServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        if (serverStatus.equals("Online")) {
            button_1.setEnabled(false);
            button_3.setEnabled(true);
        } else {
            button_1.setEnabled(true);
            button_3.setEnabled(false);
        }

        add(statusServerJira);
        add(new Div());
        add(button_1);
        add(new Div());
        add(button_3);

    }

}
