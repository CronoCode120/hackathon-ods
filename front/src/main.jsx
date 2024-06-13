import React from 'react';
import ReactDOM from 'react-dom/client';
import Index from './pages/Index.jsx';
import Room from './pages/Room.jsx';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import './index.css';

const router = createBrowserRouter([
  {
    path: '/',
    element: <Index />
  },
  {
    path: '/room',
    element: <Room />
  }
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
