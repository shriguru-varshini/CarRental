import axios from "axios";

const API_URL = "http://localhost:8080/cars";

const carService = {
  getAllCars: async () => {
    try {
      const response = await axios.get(API_URL);
      return response.data;
    } catch (error) {
      console.error("Error fetching cars:", error);
      return null;
    }
  },

  getCarById: async (id) => {
    try {
      const response = await axios.get(`${API_URL}/${id}`);
      return response.data;
    } catch (error) {
      console.error(`Error fetching car with ID ${id}:`, error);
      return null;
    }
  },


  addCar: async (carData) => {
    try {
      const response = await axios.post(API_URL, carData);
      return response.data;
    } catch (error) {
      console.error("Error adding car:", error);
      return null;
    }
  },

  updateCar: async (id, updatedCarData) => {
    try {
      const response = await axios.put(`${API_URL}/${id}`, updatedCarData);
      return response.data;
    } catch (error) {
      console.error(`Error updating car with ID ${id}:`, error);
      return null;
    }
  },

  deleteCar: async (id) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      return true;
    } catch (error) {
      console.error(`Error deleting car with ID ${id}:`, error);
      return false;
    }
  },
};

export default carService;
