package com.rnko.webportal.backend.rest.controller;




import com.atlassian.jira.issue.fields.rest.json.beans.IssueTypeJsonBean;
import com.rnko.webportal.backend.rest.data.Issue;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atlassian.jira.issue.fields.rest.json.beans.IssueRefJsonBean;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;


@RestController
public class IssueController {
    @GetMapping("/issue")
    public Issue  greeting(@RequestParam(value="key", required=false, defaultValue="") String key) {
        try {
            /*RestTemplate restTemplate = new RestTemplate();
            String fooResourceUrl = "http://localhost:2990/jira/rest/api/2/issue/RNKOIT-1";
            IssueTypeJsonBean issue = restTemplate.getForObject(fooResourceUrl, IssueTypeJsonBean.class);*/

            HttpHeaders headers = new HttpHeaders();
            String auth = "admin" + ":" + "admin";
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic " + new String(encodedAuth);
            headers.set("Authorization", authHeader);
            headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("my_other_key", "my_other_value");
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            RestTemplate restTemplate = new RestTemplate();

            // Send request with GET method, and Headers.
            ResponseEntity<Issue> response = restTemplate.exchange("http://localhost:2990/jira/rest/api/2/issue/RNKOIT-1", //
                    HttpMethod.GET, entity, Issue.class);

            Issue  result = response.getBody();
            Map<String, ?> issuetype = (Map<String, ?>) result.getFields().get("issuetype");
            System.out.println(issuetype.get("description"));

            return result;
        } catch (Exception e) {
            System.out.println("------------------------" + e);
        }

        //Issue issue = new Issue();
        /*issue.setKey("RNKOIT-1");
        issue.setId(12150);
        issue.setSummary("Вот это заявка");*/

        return null;
    }
}
