package com.example.RegistrationData.repositories;

import java.io.IOException;
import java.util.List;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.RegistrationData.model.InputData;

@Repository
public class InputDataRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // SQL queries
    private static final String INSERT_SQL = "INSERT INTO my_form_data (name, description, image) VALUES (:name, :description, :image)";
    private static final String SELECT_ALL_SQL = "SELECT * FROM my_form_data";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM my_form_data WHERE id = :id";
    private static final String SELECT_IMAGE_BY_ID_SQL = "SELECT image FROM my_form_data WHERE id = :id";

    public void test(){
        System.out.println("Hello world!");
    }

    // Save form data into the database
    public void saveData(InputData formData , MultipartFile file ) throws IOException {
        MapSqlParameterSource params = new MapSqlParameterSource();
        
        params.addValue("name", formData.getName());
        params.addValue("description", formData.getDescription());
        params.addValue("image", file.getBytes());
        
        namedParameterJdbcTemplate.update(INSERT_SQL, params);
        // wil return some java class object
    }

    // Get all form data from the database
    public List<InputData> getAllData() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_SQL, new RowMapper<InputData>() {
            @Override
            public InputData mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                InputData data = new InputData();
                data.setId(rs.getLong("id"));
                data.setName(rs.getString("name"));
                data.setDescription(rs.getString("description"));
                byte[] imageBytes = rs.getBytes("image");
                
                // Convert image bytes to Base64 string
        if (imageBytes != null) {
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            data.setImageString(base64Image);// Assuming `setImageString` accepts a String
        }
                // data.setImageData(rs.getBytes("image"));
                return data;
            }
        });
    }

    // Get image data by ID using NamedParameterJdbcTemplate
    public byte[] getImageById(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        List<byte[]> images = namedParameterJdbcTemplate.query(
            SELECT_IMAGE_BY_ID_SQL, 
            params, 
            (rs, rowNum) -> rs.getBytes("image")
        );
        
        return images.isEmpty() ? null : images.get(0);  // Return the first image if available
    }
}
