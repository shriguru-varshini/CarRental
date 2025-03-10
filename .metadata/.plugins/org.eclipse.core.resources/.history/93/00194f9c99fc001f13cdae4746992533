import { useEffect, useState } from "react";
import paymentService from "../../service/paymentService";

const ShowPayments = () => {
  const [payments, setPayments] = useState([]);
  const [filters, setFilters] = useState({
    paymentId: "",
    userName: "",
  });

  useEffect(() => {
    const fetchPayments = async () => {
      const data = await paymentService.getAllPayments();
      if (data) setPayments(data);
    };
    fetchPayments();
  }, []);

  const handleFilterChange = (e) => {
    setFilters({ ...filters, [e.target.name]: e.target.value });
  };

  const filteredPayments = payments.filter((payment) => {
    return (
      (filters.paymentId ? payment.id.toString().includes(filters.paymentId) : true) &&
      (filters.userName ? payment.user.name.toLowerCase().includes(filters.userName.toLowerCase()) : true)
    );
  });

  return (
    <div>
      <h2>All Payments</h2>

      {/* Filters */}
      <div>
        <label>Payment ID: </label>
        <input
          type="text"
          name="paymentId"
          value={filters.paymentId}
          onChange={handleFilterChange}
        />
      </div>

      <div>
        <label>User Name: </label>
        <input
          type="text"
          name="userName"
          value={filters.userName}
          onChange={handleFilterChange}
        />
      </div>

      {/* Table */}
      <table border="1">
        <thead>
          <tr>
            <th>Payment ID</th>
            <th>User Name</th>
            <th>Car</th>
            <th>Reservation ID</th>
            <th>Time of Reservation</th>
            <th>Amount</th> {/* New column for payment amount */}
          </tr>
        </thead>
        <tbody>
          {filteredPayments.length > 0 ? (
            filteredPayments.map((payment) => (
              <tr key={payment.id}>
                <td>{payment.id}</td>
                <td>{payment.user.name}</td>
                <td>{`${payment.reservation.car.brand} ${payment.reservation.car.model}`}</td>
                <td>{payment.reservation.id}</td>
                <td>{new Date(payment.createdAt).toLocaleString()}</td>
                <td>&#8377; {payment.amount}</td> {/* Displaying the amount */}
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="6">No payments match your criteria.</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default ShowPayments;
