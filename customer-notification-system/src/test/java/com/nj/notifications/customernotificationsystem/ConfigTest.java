package com.nj.notifications.customernotificationsystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;

@SpringBootTest
@AutoConfigureMockMvc
class ConfigTest {

    @Autowired
    private MockMvc mockMvc;

    //makes sure that unauthenticated users get sent to the login page
    @Test
    void redirectUnauthenticatedToLoginTest() throws Exception {
        mockMvc.perform(get("/admin/dashboard")).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));
    }

    //makes sure that users with admin role can access the admin dashboard page
    @Test
    @WithMockUser(roles = "ADMIN")
    void allowAdminToAccessDashboardTest() throws Exception {
        mockMvc.perform(get("/admin/dashboard")).andExpect(status().isOk());
    }
}
