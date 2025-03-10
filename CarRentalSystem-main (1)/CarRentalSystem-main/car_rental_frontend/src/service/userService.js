import axios from "axios";

const API_URL = "http://localhost:8080/users";

const userService = {
  getAllUsers: async () => {
    try {
      const response = await axios.get(API_URL);
      return response.data;
    } catch (error) {
      console.error("Error fetching users:", error);
      return null;
    }
  },

  getUserById: async (id) => {
    try {
      const response = await axios.get(`${API_URL}/${id}`);
      return response.data;
    } catch (error) {
      console.error(`Error fetching user with ID ${id}:`, error);
      return null;
    }
  },

  getUserByEmail: async (email) => {
    try {
      const response = await axios.get(`${API_URL}/email/${email}`);
      return response.data;
    } catch (error) {
      console.error(`Error fetching user with email ${email}:`, error);
      return null;
    }
  },

  getUserByPhone: async (phone) => {
    try {
      const response = await axios.get(`${API_URL}/phone/${phone}`);
      return response.data;
    } catch (error) {
      console.error(`Error fetching user with phone ${phone}:`, error);
      return null;
    }
  },

  getUserByRole: async (role) => {
    try {
      const response = await axios.get(`${API_URL}/role/${role}`);
      return response.data;
    } catch (error) {
      console.error(`Error fetching users with role ${role}:`, error);
      return null;
    }
  },

  addUser: async (userData) => {
    try {
      const response = await axios.post(API_URL, userData);
      return response.data;
    } catch (error) {
      console.error("Error adding user:", error);
      return null;
    }
  },

  addAdmin: async (userData) => {
    try {
      const response = await axios.post(`${API_URL}/admin`, userData);
      return response.data;
    } catch (error) {
      console.error("Error adding admin:", error);
      return null;
    }
  },

  addCustomer: async (userData) => {
    try {
      const response = await axios.post(`${API_URL}/customer`, userData);
      return response.data;
    } catch (error) {
      console.error("Error adding customer:", error);
      return null;
    }
  },

  login: async (email, password) => {
    try {
      const response = await axios.post(`${API_URL}/login`, { email, password });
      return response.data;
    } catch (error) {
      console.error("Login failed:", error);
      return null;
    }
  },
  updateUser: async (id, updatedUserData) => {
    try {
      const response = await axios.put(`${API_URL}/${id}`, updatedUserData);
      return response.data;
    } catch (error) {
      console.error(`Error updating user with ID ${id}:`, error);
      return null;
    }
  },
  deleteUser: async (id) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      return true;
    } catch (error) {
      console.error(`Error deleting user with ID ${id}:`, error);
      return false;
    }
  },
};

export default userService;
