import { useState } from "react";
import paymentService from "../../service/paymentService";

const generateTransactionId = () => {
  return "TXN" + Math.floor(1000000000000 + Math.random() * 9000000000000);
};

const AddPayment = ({ reservationId, paymentMethod }) => {
  const [amount, setAmount] = useState("");
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState("");

  const handlePayment = async (e) => {
    e.preventDefault();
    setLoading(true);
    setMessage("");

    const transactionId = generateTransactionId();
    const paymentStatus = "Completed"; // Assuming successful payment

    try {
      const response = await paymentService.processPayment(
        reservationId,
        paymentMethod,
        amount,
        paymentStatus,
        transactionId
      );

      if (response) {
        setMessage("Payment successful!");
        setAmount("");
      } else {
        setMessage("Payment failed.");
      }
    } catch (error) {
      setMessage("An error occurred during payment.");
      console.error("Payment error:", error);
    }

    setLoading(false);
  };

  return (
    <div>
      <h2>Add Payment</h2>
      <form onSubmit={handlePayment}>
        <div>
          <label>Amount:</label>
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            required
          />
        </div>
        <button type="submit" disabled={loading}>
          {loading ? "Processing..." : "Pay"}
        </button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
};

export default AddPayment;
