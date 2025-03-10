import axios from "axios";

const API_URL = "http://localhost:8080/payments";

const paymentService = {
  getAllPayments: async () => {
    try {
      const response = await axios.get(API_URL);
      return response.data;
    } catch (error) {
      console.error("Error fetching payments:", error);
      return null;
    }
  },

  getPaymentById: async (id) => {
    try {
      const response = await axios.get(`${API_URL}/${id}`);
      return response.data;
    } catch (error) {
      console.error(`Error fetching payment with ID ${id}:`, error);
      return null;
    }
  },

  getPaymentsByUserId: async (userId) => {
    try {
      const response = await axios.get(`${API_URL}/user/${userId}`);
      return response.data;
    } catch (error) {
      console.error(`Error fetching payments for user with ID ${userId}:`, error);
      return null;
    }
  },

  processPayment: async (reservationId, paymentMethod, amount, paymentStatus, transactionId) => {
    try {
        const response = await axios.post(
            `${API_URL}?reservationId=${reservationId}&paymentMethod=${encodeURIComponent(paymentMethod)}`,
            { amount, paymentStatus, transactionId }
        );
        return response.data;
    } catch (error) {
        console.error("Error processing payment:", error);
        return null;
    }
},

};

export default paymentService;
