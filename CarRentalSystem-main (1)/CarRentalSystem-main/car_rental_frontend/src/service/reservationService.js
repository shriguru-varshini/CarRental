import axios from "axios";

const API_URL = "http://localhost:8080/reservations";

const reservationService = {
  getAllReservations: async () => {
    try {
      const response = await axios.get(API_URL);
      return response.data;
    } catch (error) {
      console.error("Error fetching reservations:", error);
      return null;
    }
  },

  getReservationById: async (id) => {
    try {
      const response = await axios.get(`${API_URL}/${id}`);
      return response.data;
    } catch (error) {
      console.error(`Error fetching reservation with ID ${id}:`, error);
      return null;
    }
  },

  getReservationsByUserId: async (userId) => {
    try {
      const response = await axios.get(`${API_URL}/user/${userId}`);
      return response.data;
    } catch (error) {
      console.error(`Error fetching reservations for user ID ${userId}:`, error);
      return null;
    }
  },

  getReservationsByCarId: async (carId) => {
    try {
      const response = await axios.get(`${API_URL}/car/${carId}`);
      return response.data;
    } catch (error) {
      console.error(`Error fetching reservations for car ID ${carId}:`, error);
      return null;
    }
  },

  createReservation: async ({ userId, carId, startDatetime, endDatetime, totalPrice }) => {
    try {
      const response = await axios.post(
        `${API_URL}?userId=${userId}&carId=${carId}`,
        { startDatetime, endDatetime, totalPrice }
      );
      return response.data;
    } catch (error) {
      console.error("Error creating reservation:", error);
      return null;
    }
  },
  
  updateReservation : async (reservationId, userId, carId, reservationData) => {
      try {
          const response = await axios.put(
              `${API_URL}/${reservationId}?userId=${userId}&carId=${carId}`,
              reservationData,
              {
                  headers: {
                      "Content-Type": "application/json",
                  },
              }
          );
          return response.data;
      } catch (error) {
          console.error("Error updating reservation:", error);
          throw error;
      }
  },

  cancelReservation: async (id) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      return true;
    } catch (error) {
      console.error(`Error canceling reservation with ID ${id}:`, error);
      return false;
    }
  },
};

export default reservationService;
