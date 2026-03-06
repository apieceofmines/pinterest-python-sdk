// Smooth scroll for navigation links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({ behavior: 'smooth' });
        }
    });
});

// Contact form submission
const form = document.querySelector('.contact-form');
if (form) {
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        // In a real app, this would send data to the backend
        alert('Thank you! We\'ll be in touch soon.');
        form.reset();
    });
}

// Button click handlers
document.querySelectorAll('.btn-primary, .btn-secondary').forEach(btn => {
    btn.addEventListener('click', function (e) {
        const text = this.textContent.toLowerCase();
        if (text.includes('trial')) {
            alert('Starting your free trial...');
        } else if (text.includes('started')) {
            alert('Sign up to get started!');
        } else if (text.includes('more')) {
            document.querySelector('#features').scrollIntoView({ behavior: 'smooth' });
        }
    });
});

// Log tracking info for analytics
console.log('A Piece of Mines - Family Online Kids Product');
console.log('Tracking ID: 549768018410');
console.log('Environment:', process.env.NODE_ENV || 'production');
