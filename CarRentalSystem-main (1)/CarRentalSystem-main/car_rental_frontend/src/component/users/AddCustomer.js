import React, { useState } from 'react';
import userService from '../../service/userService';

const AddCustomer = () => {
    const [customerData, setCustomerData] = useState({
        name: '',
        email: '',
        phone: '',
        password: '',
    });

    const [error, setError] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCustomerData({ ...customerData, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');

        try {
            const response = await userService.addCustomer(customerData);
            if (response) {
                alert('Customer added successfully!');
                setCustomerData({ name: '', email: '', phone: '', password: '' }); // Clear form
            } else {
                setError('Failed to add customer.');
            }
        } catch (err) {
            setError('Something went wrong. Please try again.');
            console.error('Error adding customer:', err);
        }
    };

    return (
        <div>
            <h2>Add Customer</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Name:</label>
                    <input
                        type="text"
                        name="name"
                        value={customerData.name}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        name="email"
                        value={customerData.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Phone:</label>
                    <input
                        type="text"
                        name="phone"
                        value={customerData.phone}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        name="password"
                        value={customerData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                {error && <p style={{ color: 'red' }}>{error}</p>}
                <button type="submit">Add Customer</button>
            </form>
        </div>
    );
};

export default AddCustomer;
