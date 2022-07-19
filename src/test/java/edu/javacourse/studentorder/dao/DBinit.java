package edu.javacourse.studentorder.dao;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DBinit {

    public static void createDb() throws Exception {
        URL tables_script_url = DBinit.class.getClassLoader().getResource("student_project.sql");
        URL data_script_url = DBinit.class.getClassLoader().getResource("student_data.sql");
        List<String> tables = Files.readAllLines(Paths.get(tables_script_url.toURI()));
        List<String> data = Files.readAllLines(Paths.get(data_script_url.toURI()));
        String sql1 = tables.stream()
                .collect(Collectors.joining());
        String sql2 = data.stream()
                .collect(Collectors.joining());
        try(
                Connection con = ConnectionBuilder.getConnection();
                Statement statement = con.createStatement();
        ){
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
        }
    }
}
