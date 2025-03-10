import { useEffect, useState } from "react";
import reservationService from "../../service/reservationService";

const ShowReservations = () => {
  const [reservations, setReservations] = useState([]);
  const [filters, setFilters] = useState({
    userName: "",
    carBrand: "",
    carModel: "",
    startTime: "",
  });

  useEffect(() => {
    const fetchReservations = async () => {
      const data = await reservationService.getAllReservations();
      if (data) setReservations(data);
    };
    fetchReservations();
  }, []);

  const handleFilterChange = (e) => {
    setFilters({ ...filters, [e.target.name]: e.target.value });
  };

  const filteredReservations = reservations.filter((res) => {
    return (
      (filters.userName ? res.user.name.toLowerCase().includes(filters.userName.toLowerCase()) : true) &&
      (filters.carBrand ? res.car.brand.toLowerCase().includes(filters.carBrand.toLowerCase()) : true) &&
      (filters.carModel ? res.car.model.toLowerCase().includes(filters.carModel.toLowerCase()) : true) &&
      (filters.startTime ? res.startDatetime.startsWith(filters.startTime) : true)
    );
  });

  return (
    <div>
      <h2>All Reservations</h2>

      {/* Filters */}
      <div>
        <label>User Name: </label>
        <input
          type="text"
          name="userName"
          value={filters.userName}
          onChange={handleFilterChange}
        />
      </div>

      <div>
        <label>Car Brand: </label>
        <input
          type="text"
          name="carBrand"
          value={filters.carBrand}
          onChange={handleFilterChange}
        />
      </div>

      <div>
        <label>Car Model: </label>
        <input
          type="text"
          name="carModel"
          value={filters.carModel}
          onChange={handleFilterChange}
        />
      </div>

      <div>
        <label>Start Time: </label>
        <input
          type="date"
          name="startTime"
          value={filters.startTime}
          onChange={handleFilterChange}
        />
      </div>

      {/* Table */}
      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>User Name</th>
            <th>Car</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Status</th>
            <th>Total Price</th>
          </tr>
        </thead>
        <tbody>
          {filteredReservations.length > 0 ? (
            filteredReservations.map((res) => (
              <tr key={res.id}>
                <td>{res.id}</td>
                <td>{res.user.name}</td>
                <td>{`${res.car.brand} ${res.car.model}`}</td>
                <td>{new Date(res.startDatetime).toLocaleString()}</td>
                <td>{new Date(res.endDatetime).toLocaleString()}</td>
                <td>{res.status}</td>
                <td>${res.totalPrice}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="7">No reservations match your criteria.</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default ShowReservations;
