package com.herokuapp.computerdatabase.pages;

import com.herokuapp.computerdatabase.ProjectWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


    @Component
    public class Pages {
        private final ProjectWebDriver projectWebDriver;

        @Value("${baseURL}")
        private String baseURL;

        @Autowired
        public Pages(ProjectWebDriver projectWebDriver) {
            this.projectWebDriver = projectWebDriver;
        }

        public HomePage homePage() {
            return new HomePage(projectWebDriver.getWebDriver(), baseURL);
        }

        public AddComputerPage addComputerPage() {
            return new AddComputerPage(projectWebDriver.getWebDriver());
        }
}
