# A Piece of Mines - Landing Page

Beautiful, responsive landing page for the **Family Online Kids Product** at `https://apieceofmines.com`.

## Files

- `index.html` — Main page structure with sections for features, safety, pricing, and contact.
- `style.css` — Modern, responsive styling with dark mode support.
- `script.js` — Smooth scrolling, form handling, and analytics tracking.

## Quick Start

### Option 1: Open Locally
Simply open `index.html` in your browser:

```bash
open index.html
# or
firefox index.html
```

### Option 2: Serve with Python
```bash
python3 -m http.server 8000
# Visit http://localhost:8000
```

### Option 3: Use with Spring Boot
Copy files to `java-spring-sample/src/main/resources/static/` and update the Spring Boot app to serve them at `/`:

```bash
cp -r . ../java-spring-sample/src/main/resources/static/
```

Then access at `http://localhost:8080/`

## Features

✅ **Fully Responsive** — Works on mobile, tablet, and desktop  
✅ **Modern Design** — Clean, professional, family-friendly aesthetic  
✅ **Accessibility** — Semantic HTML and keyboard navigation  
✅ **Fast** — No frameworks, pure HTML/CSS/JS (~50KB)  
✅ **Tracking Integration** — Includes tracking ID `549768018410` in footer and logs  

## Sections

1. **Hero** — Eye-catching banner with CTA buttons
2. **Features** — 6 key benefits with icons
3. **Safety** — Trust and compliance information
4. **Pricing** — 3-tier pricing model
5. **Contact** — Simple contact form
6. **Footer** — Links and tracking info

## Contact Information

**Primary Contact:** joserafael@apieceofmines.com

This email is used for:
- Landing page contact form
- Customer support inquiries
- Business partnerships
- Technical issues

## Customization

Update these in `index.html`:
- Company name / branding
- Phone number
- Social media links
- Power words in CTA buttons

Update brand colors in `style.css`:
```css
:root {
    --primary: #6366f1;    /* Change this */
    --secondary: #ec4899;  /* And this */
}
```

## Tracking ID

The landing page includes and logs the tracking ID `549768018410` in:
- Footer text
- Browser console
- Contact form (optional submission)

---

Ready to deploy? Simply upload the 3 files to your web host or use the Spring Boot integration above.
